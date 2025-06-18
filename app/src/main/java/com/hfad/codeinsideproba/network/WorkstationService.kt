package com.hfad.codeinsideproba.network

import com.hfad.codeinsideproba.model.Workstation

class WorkstationService {
    fun getCoworkingWorkstations(): List<Workstation> {
        return listOf(
            Workstation("1", 0.165f, 0.44f, "Сотрудник: Иван Петров", "Должность: Team Lead"),
            Workstation("2", 0.3f, 0.44f, "Сотрудник: Анна Сидорова", "Должность: Android Developer"),
            Workstation("3", 0.455f, 0.44f, "Сотрудник: Петр Иванов", "Должность: Backend Developer"),
            Workstation("4", 0.595f, 0.44f, "Сотрудник: Мария Кузнецова", "Должность: QA Engineer"),
            Workstation("5", 0.75f, 0.44f, "Сотрудник: Алексей Смирнов", "Должность: UI/UX Designer"),
            Workstation("6", 0.16f, 0.512f, "Сотрудник: Елена Васильева", "Должность: Product Manager"),
            Workstation("7", 0.3f, 0.512f, "Сотрудник: Дмитрий Попов", "Должность: Frontend Developer"),
            Workstation("8", 0.45f, 0.512f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("9", 0.59f, 0.512f, "Сотрудник: Сергей Федоров", "Должность: DevOps Engineer"),
            Workstation("10", 0.744f, 0.512f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("11", 0.31f, 0.35f, "Шкаф с фотоприборами", "фотоаппарат, камера, стенд"),
            Workstation("12", 0.25f, 0.59f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("13", 0.31f, 0.59f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("14", 0.446f, 0.59f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("15", 0.505f, 0.59f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("16", 0.632f, 0.59f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("17", 0.69f, 0.59f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("18", 0.69f, 0.641f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("19", 0.632f, 0.641f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("20", 0.505f, 0.641f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("21", 0.446f, 0.641f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("22", 0.31f, 0.641f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
            Workstation("23", 0.25f, 0.641f, "Сотрудник: Татьяна Морозова", "Должность: Business Analyst"),
        )

    }

    fun getFloorThreeWorkstation(): List<Workstation> {
        return listOf(
            Workstation("1", 0.32f, 0.5f, "Сотрудник: Иван Петров", "Должность: Team Lead"),
            Workstation("2", 0.32f, 0.53f, "Сотрудник: Анна Сидорова", "Должность: Android Developer"),
            Workstation("3", 0.32f, 0.56f, "Сотрудник: Петр Иванов", "Должность: Backend Developer"),
            Workstation("4", 0.32f, 0.59f, "Сотрудник: Мария Кузнецова", "Должность: QA Engineer"),
            Workstation("5", 0.43f, 0.502f, "Сотрудник: Алексей Смирнов", "Должность: UI/UX Designer"),
            Workstation("6", 0.43f, 0.532f, "Сотрудник: Елена Васильева", "Должность: Product Manager"),
            Workstation("7", 0.43f, 0.562f, "Сотрудник: Дмитрий Попов", "Должность: Frontend Developer"),
            Workstation("8", 0.43f, 0.592f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("9", 0.49f, 0.502f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("10", 0.49f, 0.532f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("11", 0.49f, 0.562f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("12", 0.49f, 0.592f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("13", 0.592f, 0.502f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("14", 0.592f, 0.532f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("15", 0.592f, 0.562f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("16", 0.592f, 0.592f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("17", 0.7f, 0.502f, "Шкаф №3", "Радиоприборы"),
            Workstation("18", 0.09f, 0.507f, "Шкаф №4", "Документы"),
            Workstation("19", 0.32f, 0.39f, "Шкаф №5", "Документы"),
        )
    }
    fun getFloorFourWorkstation(): List<Workstation> {
        return listOf(
            Workstation("1", 0.018f, 0.48f, "Сотрудник: Иван Петров", "Должность: Team Lead"),
            Workstation("2", 0.018f, 0.512f, "Сотрудник: Анна Сидорова", "Должность: Android Developer"),
            Workstation("3", 0.018f, 0.542f, "Сотрудник: Петр Иванов", "Должность: Backend Developer"),
            Workstation("4", 0.1f, 0.48f, "Сотрудник: Мария Кузнецова", "Должность: QA Engineer"),
            Workstation("5", 0.1f, 0.512f, "Сотрудник: Алексей Смирнов", "Должность: UI/UX Designer"),
            Workstation("6", 0.1f, 0.542f, "Сотрудник: Елена Васильева", "Должность: Product Manager"),
            Workstation("7", 0.285f, 0.41f, "Сотрудник: Дмитрий Попов", "Должность: Frontend Developer"),
            Workstation("8", 0.213f, 0.51f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("9", 0.213f, 0.54f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("10", 0.31f, 0.51f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("11", 0.31f, 0.54f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("12", 0.4f, 0.43f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("13", 0.592f, 0.502f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("14", 0.592f, 0.532f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("15", 0.592f, 0.562f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("16", 0.592f, 0.592f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("17", 0.7f, 0.502f, "Шкаф №3", "Радиоприборы"),
            Workstation("18", 0.09f, 0.507f, "Шкаф №4", "Документы"),
            Workstation("19", 0.32f, 0.39f, "Шкаф №5", "Документы"),
        )
    }
    fun getFloorSixWorkstation(): List<Workstation> {
        return listOf(
            Workstation("1", 0.32f, 0.5f, "Сотрудник: Иван Петров", "Должность: Team Lead"),
            Workstation("2", 0.32f, 0.53f, "Сотрудник: Анна Сидорова", "Должность: Android Developer"),
            Workstation("3", 0.32f, 0.56f, "Сотрудник: Петр Иванов", "Должность: Backend Developer"),
            Workstation("4", 0.32f, 0.59f, "Сотрудник: Мария Кузнецова", "Должность: QA Engineer"),
            Workstation("5", 0.43f, 0.502f, "Сотрудник: Алексей Смирнов", "Должность: UI/UX Designer"),
            Workstation("6", 0.43f, 0.532f, "Сотрудник: Елена Васильева", "Должность: Product Manager"),
            Workstation("7", 0.43f, 0.562f, "Сотрудник: Дмитрий Попов", "Должность: Frontend Developer"),
            Workstation("8", 0.43f, 0.592f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("9", 0.49f, 0.502f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("10", 0.49f, 0.532f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("11", 0.49f, 0.562f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("12", 0.49f, 0.592f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("13", 0.592f, 0.502f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("14", 0.592f, 0.532f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("15", 0.592f, 0.562f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("16", 0.592f, 0.592f, "Сотрудник: Ольга Новикова", "Должность: HR Manager"),
            Workstation("17", 0.7f, 0.502f, "Шкаф №3", "Радиоприборы"),
            Workstation("18", 0.09f, 0.507f, "Шкаф №4", "Документы"),
            Workstation("19", 0.32f, 0.39f, "Шкаф №5", "Документы"),
        )
    }
}