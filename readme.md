# Lestora Support

This is a useful utility that I believe anybody can use.  Minecraft's API has an ability to check what block is supporting the player's weight... sort of.

There is a lot of ambiguity, it doesn't quite work when you're shift-hanging off the edge of a block or jumping, or with chests.  I wrote this a while back so I forget the real reasons.

Instead, this mod uses the player's bounding box, state (flying/falling/swimming), and the environment to see what is supporting the player's weight.

## Features
- **Usage:** This simply internally tracks which block is supporting the player in realtime.  It optionally depends on Lestora Debug if you want to see debug info that shows which block is supporting the player's weight.

## Manual Installation
1. Download the mod JAR from CurseForge.
2. Place the JAR file into your `mods` folder.
3. Launch Minecraft with the Forge profile.

## Commands
- Use the command `/lestora blockSupport print` to print the current support block information.  This is only useful if you don't use the Lestora Debug mod to be able to see it in real time.

## Compatibility
- **Minecraft Version:** 1.21.4
- **Forge Version:** 54.1.0

## Troubleshooting
If you run into issues (e.g., crashes or unexpected behavior), check the logs in your `crash-reports` or `logs` folder. You can also open an issue on the mod’s GitHub repository.

## Contributing
Contributions are welcome! Please submit pull requests or open issues if you have suggestions or bug reports.

## License
This project is licensed under the MIT License.