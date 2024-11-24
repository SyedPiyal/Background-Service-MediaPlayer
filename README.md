# Background Service MediaPlayer

This is a simple Android project that demonstrates how to create a background service that plays media (the default ringtone) in a loop while running in the foreground. The service is started and stopped via buttons in the MainActivity. This project is intended to demonstrate the usage of `Service`, `MediaPlayer`, and `Notification` in Android development.

## Features

- **Background Service**: A `Service` runs in the background to play media continuously.
- **Foreground Service**: The service runs as a foreground service, so it is not killed by the system when the app is in the background.
- **MediaPlayer**: The service uses `MediaPlayer` to play the default ringtone in a loop.
- **Notification**: A persistent notification is shown while the service is running.
- **Buttons to Control Service**: Two buttons are provided in the `MainActivity` to start and stop the service.


## Requirements

- Android 8.0 (API level 26) or higher to use foreground services and notification channels.

## Installation

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/Background-Service-MediaPlayer.git
