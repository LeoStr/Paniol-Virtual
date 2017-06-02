package paniolvirtual

import paniolvirtual.Role
import paniolvirtual.User
import paniolvirtual.UserRole

class BootStrap {
    def init = { servletContext ->
        /* //Armamos un usuario
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()
        //def role = Role.findByAuthority('ROLE_USER')
        def userUser = new User(username: 'cliente', password: 'cliente', nombre: 'Cliente', apellido: 'Cliente', direccion: 'Donde sea').save(flush:true, failOnError: true, insert: true)
        UserRole.create userUser, userRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        def adminUser = new User(username: 'straguzzi', password: 'micasa', nombre: 'Leonardo', apellido: 'Straguzzi', direccion: 'Donde sea').save(flush:true, failOnError: true, insert: true)
        UserRole.create adminUser, adminRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        def admin2User = new User(username: 'quinteros', password: 'guille', nombre: 'Guillermo', apellido: 'Quinteros', direccion: 'Donde sea').save(flush:true, failOnError: true, insert: true)
        UserRole.create admin2User, adminRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        */
        //assert User.count() == 2
        //assert Role.count() == 2
        //assert UserRole.count() == 2
        
    }

    def destroy = {
    }
}
