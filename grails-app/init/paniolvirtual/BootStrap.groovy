package paniolvirtual

import paniolvirtual.Role
import paniolvirtual.User
import paniolvirtual.UserRole

class BootStrap {
    def init = { servletContext ->
        /* //Armamos un usuario
        //def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        //def userRole = new Role(authority: 'ROLE_USER').save()
        def role = Role.findByAuthority('ROLE_USER')
        def testUser = new User(username: 'cliente', password: 'cliente', nombre: 'Cliente', apellido: 'Cliente', direccion: 'Donde sea').save(flush:true, failOnError: true, insert: true)
        UserRole.create testUser, role
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        //assert User.count() == 2
        //assert Role.count() == 2
        //assert UserRole.count() == 2
        */
    }

    def destroy = {
    }
}
