# SoundScribe
## Description
A quality of life (QoL) mod that pings the user when keywords or keyword combinations are detected in any chat messages received by the client.

This mod is intended to only be used client-side ONLY. Works in single-player.

- Versions
  - Minecraft 1.16.5
  - Forge 36.2.34

## Current Features
- **Plays a configurable sound to the client**
  - Supports any sound registered in Minecraft
    - Default: `soundscribe:ping`
  - Configure the category the sound plays in (Ex: Master, Weather, Music)
  - Configure how loud the sound
  - Supports list of keywords or keyword combinations (erroneous / extra spaces matter)
    - Keywords
      - Will only play sound if keyword detected in any message
      - Keyword Substitutions
        - `%playername%` - Client player name
    - Keyword Combinations
      - Will only play sound if ALL keywords deteced in any message
      - Example: `thing1+thing2+%playername%`
      - Does not support text sent in multiple messages


## Planned Features
- **Message Highlighting**
  - Highlight the message that pinged you in the chat box
  - Config
    - Keyword Highlighting - text color, background color?
    - Message background color


- **In-Game Config**
  - An in-game config page that doesn't rely on external mods to make it look nice


## Configs
- `searchTerms`
  - _**Default** = `[  ]`_
  - List of keywords and keyword combinations to search messages for
  - Surround with quotes
    - Example:  `searchTerms = ["thing1", "thing2+%playername%"]`
- **Ping**
  - `pingSound`
    - _**Default** = `"soundscribe:ping"`_
    - Sound to play
  - `soundCategory`
    - _**Default** = `"master"`_
    - Accepted Values:  `master`, `music`, `record`, `weather`, `hostile`, `neutral`, `player`, `block`, `ambient`, `voice`
    - Category to play ping in
  - `pingVolume`
    - _**Default** = `0.5`_
    - Range: `0.0 ~ 1.0`
    - How loud the ping is
  - `pingPitch`
    - _**Default** = `0.5`_
    - Range: `0.0 ~ 1.0`
    - How high the ping is