package paniolvirtual

import paniolvirtual.Role
import paniolvirtual.User
import paniolvirtual.UserRole

class BootStrap {
    def init = { servletContext ->
        /*  /Armamos un primer usuario
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()
        def testUser = new User(username: 'quinteros', password: 'guille', nombre: 'Guillermo', apellido: 'Quinteros', direccion: 'No me acuerdo tu direccion').save(flush:true, failOnError: true, insert: true)
        UserRole.create testUser, adminRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2
        */
    }

    def destroy = {
    }
}
