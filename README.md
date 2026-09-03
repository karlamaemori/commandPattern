# commandPattern

Imagine you're building a smart home automation system where various devices (lights, thermostat, music player, etc.) can be controlled remotely using a central hub or app. Each device has different functionalities, but you want to create a unified and flexible control mechanism.
 
Design a system that allows you to control multiple smart home devices with ease. Your goal is to create a solution where:
 
1. You can control a variety of devices from a central hub or app, sending commands like "Turn On," "Turn Off," "Increase Temperature," "Decrease Volume," etc.
2. Each device has unique actions associated with these commands. For example, turning on the lights might involve changing their brightness level, while turning on the music player may involve playing a specific playlist.
3. New devices can be seamlessly integrated into the system without modifying existing code. You want to ensure that adding a new device doesn't require changes to the central control logic.
4. Devices can be controlled without the central hub or app needing to understand the internal workings of each device. It should send high-level commands without needing low-level details.
Your challenge is to apply a design pattern that provides a flexible and scalable way to control a variety of smart home devices, ensuring that new devices can be added without disrupting the existing system's functionality.

---

# UML Diagram
 
**Command Design Pattern**

---

# Components
 
**SmarthomeApp (Client):** This represents the application used to control smart home devices. It creates the devices, wraps each device action in a concrete `Command`, and registers each command with the `DeviceController`.
 
**DeviceController (Invoker):** The `DeviceController` acts as an invoker, storing named commands and executing them on request. It has a `setCommand(name, command)` method to register/replace a command by name, and a `pressButton(name)` method to invoke the command tied to that name.
 
**Command (Interface):** An interface defining the `execute()` method, which all concrete command objects must implement. It ensures that every command can be triggered the same way, regardless of the device behind it.
 
**LightOn / LightOff (Concrete Commands):** Concrete command objects representing the "turn on" and "turn off" operations for the `Light`. They encapsulate calls to the `Light` object's `turnOn()` and `turnOff()` methods.
 
**AddingThermostat / ReducingThermostat (Concrete Commands):** Concrete command objects representing the "increase temperature" and "decrease temperature" operations for the `Thermostat`. They encapsulate calls to the `Thermostat` object's `addTemperature()` and `minusTemperature()` methods.
 
**VolumeUp / VolumeDown (Concrete Commands):** Concrete command objects representing the "increase volume" and "decrease volume" operations for the `MusicPlayer`. They encapsulate calls to the `MusicPlayer` object's `addVolume()` and `minusVolume()` methods.
 
**Light / Thermostat / MusicPlayer (Receivers):** These are the actual smart home devices being controlled. Each one knows how to perform its own actions:
- `Light` manages `brightness` and exposes `turnOn()` / `turnOff()`.
- `Thermostat` manages `temperature` and exposes `addTemperature()` / `minusTemperature()`.
- `MusicPlayer` manages `volume` and exposes `addVolume()` / `minusVolume()`.
---
 
# Why the Command Pattern?
 
- **Decoupling:** `DeviceController` never touches `Light`, `Thermostat`, or `MusicPlayer` directly — it only knows the `Command` interface. This satisfies requirement #4 (no need to understand internal device workings).
- **Extensibility:** Adding a new device (e.g., a `Fan`) only requires creating a new receiver class and one or two new `Command` implementations. `DeviceController` and `SmarthomeApp`'s invocation logic don't change. This satisfies requirement #3.
- **Uniform invocation:** Every device action, however different internally, is triggered the same way through `execute()`, letting the controller send high-level commands like `LIGHT_ON` or `THERMOSTAT_ADD` without caring how each device implements them. This satisfies requirements #1 and #2.
---
 
# Project Structure
 
```
commandPattern/
├── Command.java
├── DeviceController.java
├── Light.java
├── LightOn.java
├── LightOff.java
├── Thermostat.java
├── AddingThermostat.java
├── ReducingThermostat.java
├── MusicPlayer.java
├── VolumeUp.java
├── VolumeDown.java
└── SmarthomeApp.java
```
 
# How to Run
 
```bash
javac commandPattern/*.java
java commandPattern.SmarthomeApp
```
 
**Sample Output:**
 
```
Light is ON (Brightness: 100%)
Thermostat increased to 21°C
Music player volume increased to 60
Music player volume decreased to 50
Thermostat decreased to 20°C
Light is OFF!
```
