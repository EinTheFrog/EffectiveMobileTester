package com.example.effectivemobiletester.model

import com.example.effectivemobiletester.model.domain.UserDomain
import com.example.effectivemobiletester.model.local.UserLocal
import javax.inject.Singleton

@Singleton
class UserMapper {

    fun localToDomain(userLocal: UserLocal): UserDomain {
        return UserDomain(
            login = userLocal.login,
            password = userLocal.password,
        )
    }

    fun domainToLocal(userDomain: UserDomain): UserLocal {
        return UserLocal(
            id = 0,
            login = userDomain.login,
            password = userDomain.password,
        )
    }
}