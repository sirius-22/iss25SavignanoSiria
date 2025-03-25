# iss25SavignanoSiria
Repository per il corso Ingegneria dei Sistemi Software a.a. 2024/2025 - DISI - University of Bologna

<h2 id="Fase1 : DAGLI OGGETTI AI MICROSERVIZI">Fase 1</h2>

* [Relazione Fase 1](Fase1ISS25-SavignanoSiria.pdf)
* [Refactoring_ConwayLife25Java](Refactoring_Conwaylife25_java): Classi Java che realizzano il core business del gioco della vita di Conway
* [conwaygui](conwaygui): Sistema SpringBoot che ingloba Refactoring_ConwayLife25Java offrendo una GUI come dispositivo di I/O
* [conway25JavaMqtt](conway25JavaMqtt): GameLife standalone che interagisce via MQTT con il mondo esterno
* [conwayguialone](conwayguialone): Servizio SpringBoot che offre la GUI per intergasice via MQTT con conway25JavaMqtt
