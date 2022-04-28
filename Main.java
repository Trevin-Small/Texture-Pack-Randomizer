import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

  public static void main(String[] args) {

    // Open the block texture directory
    File blockTextures = new File("./block");

    // List of all texture filenames
    File[] listOfTextures = blockTextures.listFiles();

    // Get the number of block textures in the directory
    int numTextures = listOfTextures.length;

    // ArrayLists to randomly map texture numbers
    ArrayList<Integer> textureList = new ArrayList<Integer>(numTextures);
    ArrayList<Integer> textureMap = new ArrayList<Integer>(numTextures);

    // Populate the textureList with 1 through n (number of textures)
    for(int i = 1; i <= numTextures; i++) {
      textureList.add(i);
    }


    // Randomly map texture numbers to the textureList
    Random rand = new Random();
    int counter = 0;
    while(textureList.size() > 0) {
      int index = rand.nextInt(textureList.size());
      textureMap.add(textureList.remove(index));
      System.out.println("Texture number: " + Integer.toString(counter) + ", Mapped to texture number: " + Integer.toString(textureMap.get(textureMap.size() - 1)));
      counter++;
    }

    String oldTexturePath = "";
    String newTexturePath = "";

    for (int i = 0; i < textureMap.size(); i++) {
      // Get the string to the path of the old texture file
      oldTexturePath = "/Users/mac/Documents/Texture-Pack-Randomizer/block/" + listOfTextures[i].getName();

      // Skip over any file that isnt a .png file
      if (!oldTexturePath.substring(oldTexturePath.length() - 4).equals(".png")) {
        continue;
      }

      // Get the string to the path of the new texture file
      newTexturePath = "/Users/mac/Documents/Texture-Pack-Randomizer/assets/minecraft/textures/block/" + listOfTextures[textureMap.get(i)].getName();

      System.out.println("Old texture: " + oldTexturePath);
      System.out.println("New texture: " + newTexturePath);
      System.out.println("");

      try {
        // Create the new texture file
        File newTexture = new File(newTexturePath);
        newTexture.createNewFile();

        // Copy the old texture file to the new texture file
        Files.copy(Paths.get(oldTexturePath), Paths.get(newTexturePath), StandardCopyOption.REPLACE_EXISTING);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

}