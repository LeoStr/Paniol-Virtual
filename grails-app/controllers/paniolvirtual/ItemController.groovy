package paniolvirtual

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class ItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        String dueño = session.SPRING_SECURITY_CONTEXT.getAuthentication().getPrincipal().getUsername()
        User usuario = User.findByUsername(dueño)
        List lista = Item.findAllByDuenio(usuario)
        respond lista, model:[itemCount: lista.size()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Item item) {
        respond item
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Item(params)
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def save(Item item) {
        if (item == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (item.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond item.errors, view:'create'
            return
        }

        item.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'item.label', default: 'Item'), item.id])
                redirect item
            }
            '*' { respond item, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Item item) {
        respond item
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def update(Item item) {
        if (item == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (item.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond item.errors, view:'edit'
            return
        }

        item.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'item.label', default: 'Item'), item.id])
                redirect item
            }
            '*'{ respond item, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def delete(Item item) {

        if (item == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        item.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'item.label', default: 'Item'), item.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_ADMIN'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'item.label', default: 'Item'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
