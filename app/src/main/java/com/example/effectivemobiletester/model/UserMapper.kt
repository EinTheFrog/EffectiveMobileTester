package com.example.effectivemobiletester.model

import com.example.effectivemobiletester.model.domain.UserDomain
import com.example.effectivemobiletester.model.local.UserLocal
import javax.inject.Singleton

@Singleton
class UserMapper {

    fun localToDomain(userLocal: UserLocal): UserDomain {
        return UserDomain(
            firstName = userLocal.firstName,
            lastName = userLocal.lastName,
            phone = userLocal.phone,
        )
    }

    fun domainToLocal(userDomain: UserDomain): UserLocal {
        return UserLocal(
            id = 0,
            firstName = userDomain.firstName,
            lastName = userDomain.lastName,
            phone = userDomain.phone,
        )
    }
}