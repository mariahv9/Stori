package com.example.domain.mapper

import com.example.common.Movement
import com.example.data.db.entities.MovementEntity
import com.example.data.db.entities.UserEntity
import com.example.domain.model.UserModel

fun UserEntity.toUserModel(): UserModel {
    val movementsList = this.movements.map { movementEntity ->
        Movement(
            id = movementEntity.id,
            movement = movementEntity.movement,
            description = movementEntity.description,
            date = movementEntity.date,
            amount = movementEntity.amount
        )
    }
    return UserModel(
        id = id,
        email = email,
        password = password,
        name = name,
        surname = surname,
        balance = balance,
        isLogged = isLogged,
        movements = movementsList
    )
}

fun UserModel.toUserEntity(): UserEntity {
    val movementEntityList = this.movements.map { movement ->
        MovementEntity(
            id = movement.id,
            movement = movement.movement,
            description = movement.description,
            date = movement.date,
            amount = movement.amount
        )
    }
    return UserEntity(
        id = id,
        email = email,
        password = password,
        name = name,
        surname = surname,
        balance = balance,
        isLogged = isLogged,
        movements = movementEntityList
    )
}
