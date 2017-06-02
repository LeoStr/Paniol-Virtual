package paniolvirtual

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
    @Secured(['ROLE_ADMIN'])
class DepositoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Deposito.list(params), model:[depositoCount: Deposito.count()]
    }

    def show(Deposito deposito) {
        respond deposito
    }

    def create() {
        respond new Deposito(params)
    }

    @Transactional
    def save(Deposito deposito) {
        if (deposito == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (deposito.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond deposito.errors, view:'create'
            return
        }

        deposito.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'deposito.label', default: 'Deposito'), deposito.id])
                redirect deposito
            }
            '*' { respond deposito, [status: CREATED] }
        }
    }

    def edit(Deposito deposito) {
        respond deposito
    }

    @Transactional
    def update(Deposito deposito) {
        if (deposito == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (deposito.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond deposito.errors, view:'edit'
            return
        }

        deposito.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'deposito.label', default: 'Deposito'), deposito.id])
                redirect deposito
            }
            '*'{ respond deposito, [status: OK] }
        }
    }

    @Transactional
    def delete(Deposito deposito) {

        if (deposito == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        deposito.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'deposito.label', default: 'Deposito'), deposito.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'deposito.label', default: 'Deposito'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
