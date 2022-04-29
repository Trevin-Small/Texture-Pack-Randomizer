# Texture-Pack-Randomizer
## A fun experiment that randomly swaps block, item, and particle effect textures in Minecraft.
![Example 1](https://github.com/Trevin-Small/Texture-Pack-Randomizer/blob/main/examples/world.png)
![Example 2](https://github.com/Trevin-Small/Texture-Pack-Randomizer/blob/main/examples/mansion.png)
![Example 3](https://github.com/Trevin-Small/Texture-Pack-Randomizer/blob/main/examples/house.png)
![Example 4](https://github.com/Trevin-Small/Texture-Pack-Randomizer/blob/main/examples/example.png)
![Example 5](https://github.com/Trevin-Small/Texture-Pack-Randomizer/blob/main/examples/items.png)

### As you can see, the result is.... chaotic.
**The game is nearly unplayable like this 😂**  
**It does make for a funny joke, though I can't recommend attempting to beat the game with this texture pack...**


# Usage:
## Use My Texture Pack
- If you want to play with the texture pack I generated, navigate to ```/examples```, and download ```random_texture_pack.zip```
## Compile and generate a pack on your own
- Under Releases, download the "Texture-Pack-Generator.zip" file.
- Extract the file
- Run ```javac Main.java```
- Run ```java Main```
- Select "assets", "pack.mcmeta", and "pack.png"
- Compress the files into a ```.zip``` file.
### Thats it! The compressed file can be used as a texture pack in (Java) Minecraft.

# Creeper pig
#### (This was done manually as a joke! The java program does not randomize entity textures.)
![Example 6](https://github.com/Trevin-Small/Texture-Pack-Randomizer/blob/main/examples/creeper.png)

# Note on Entity Textures
A (feeble) attempt was made at randomizing the textures between entities.  

This problem is harder to solve, since some entities have many files and minecraft
expects all of them to be present, while other entities may only have one file.  

Remapping the files becomes harder since it isnt one-to-one. I may revisit this eventually though.  

For now, I live in peace (or constant fear?) with the manually created creeper pig.