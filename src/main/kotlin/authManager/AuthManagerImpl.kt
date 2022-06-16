package authManager.domain

import data.AuthUser
import data.authDataSet

class AuthManagerImpl : AuthManager {

    private var currentUserId = 0

    override fun login(name: String, password: String): Boolean {
        return try {
            val user: AuthUser = authDataSet.first {
                it.name == name && it.password == password
            }
            currentUserId = user.id
            true
        } catch (error: Exception) {
            println(error.localizedMessage)
            false
        }
    }

    override fun register(name: String, password: String) {
        val lastUser = authDataSet.maxByOrNull { it.id }


        val newId = lastUser?.let { it.id + 1 } ?: 1


        val newUser = AuthUser(
            id = newId,
            name = name,
            password = password,
        )

        authDataSet.add(newUser)

    }

    override fun logout() {
        TODO("Not yet implemented")
    }

    override fun getIsAuthenticated(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getUser(): AuthUser {
        TODO("Not yet implemented")
    }
}