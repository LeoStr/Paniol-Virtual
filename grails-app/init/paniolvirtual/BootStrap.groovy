package paniolvirtual

import paniolvirtual.Role
import paniolvirtual.User
import paniolvirtual.UserRole

class BootStrap {
    def init = { servletContext ->
        /*  //Armamos un primer usuario
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()
        def testUser = new User(username: 'straguzzi', password: 'micasa', nombre: 'Leonardo', apellido: 'Straguzzi', direccion: 'Av de Mayo 1316 p 3 dto D').save(flush:true, failOnError: true, insert: true)
        UserRole.create testUser, adminRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1
        */
    }

    def destroy = {
    }
}
