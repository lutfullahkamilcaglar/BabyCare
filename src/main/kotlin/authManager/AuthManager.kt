package authManager.domain

import data.AuthUser

interface AuthManager {

    fun login(name: String, password: String): Boolean

    fun register(name: String, password: String)

    fun logout()

    fun getIsAuthenticated(): Boolean

    fun getUser(): AuthUser

}