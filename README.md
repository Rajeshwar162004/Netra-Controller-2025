# Bluetooth Joystick Controller

This project is a Bluetooth-based controller application that uses a joystick and buttons for sending commands to a connected Bluetooth device. The app leverages the `Joystick_Lib` library (`com.github.Krusshnaa:Joystick_Lib:1.0`) to handle joystick functionality. It includes six buttons, a reconnection button, and displays the connection status and the currently sent command.

## Features

- **Joystick Control**: Integrated joystick to send directional commands to the connected device.
- **Six Buttons**: Each button sends a specific predefined command.
- **Reconnection Button**: Allows users to attempt reconnection if the Bluetooth connection is lost.
- **Connection Status**: Real-time status display of the Bluetooth connection (e.g., "Connected," "Disconnected").
- **Command Display**: Shows the current command being sent from the controller.

## Prerequisites

To build and run the project, you need:

- **Android Studio**: Version 22 or above.
- **Bluetooth Module/Device**: Compatible with the app (e.g., ESP32, HC-05).
- **Joystick Library**: [Joystick_Lib](https://github.com/Krusshnaa/Joystick_Lib)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Bluetooth-Joystick-Controller.git
   ```

2. Open the project in Android Studio.

3. Add the `Joystick_Lib` dependency in your `build.gradle` file:
   ```gradle
   dependencies {
       implementation 'com.github.Krusshnaa:Joystick_Lib:1.0'
   }
   ```

4. Sync your project with Gradle files.

## Usage


1.Launch the App: Open the app on your Android device.

Connect to Bluetooth Device: Select the desired Bluetooth device from the list of available paired devices.

3.Control with Joystick: Use the joystick to send directional commands to the connected device.

4.Use Buttons: Tap any of the six buttons to send specific commands.

5.Reconnection: If the connection is lost, tap the "Reconnect" button to re-establish the connection.

6.Monitor Status: Check the connection status and current command on the status display.


## Acknowledgments

- [Joystick_Lib](https://github.com/Krusshnaa/Joystick_Lib) for providing the joystick functionality.

## Contact

For any questions or feedback, please contact:

 
Email: rajesvchintawarofficial16@.com/rishi.shendre@23.vit.edu  
GitHub: [Rajeshwar162004](https://github.com/Rajeshwar162004)/[rishishendre](https://github.com/rishishendre)
