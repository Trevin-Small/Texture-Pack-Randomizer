import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Main {

  public static final String[] textureTypes = {"block/", "item/", "particle/"};
  public static final String pathToTextures = "/Users/mac/Documents/Texture-Pack-Randomizer/textures/";
  public static final String pathToTexturePack = "/Users/mac/Documents/Texture-Pack-Randomizer/assets/minecraft/textures/";

  /*
  public static void copyFolder(File source, File destination)
  {
      if (source.isDirectory())
      {
          if (!destination.exists())
          {
              destination.mkdirs();
          }
  
          String files[] = source.list();
  
          for (String file : files)
          {
              File srcFile = new File(source, file);
              File destFile = new File(destination, file);
  
              copyFolder(srcFile, destFile);
          }
      }
      else
      {
          InputStream in = null;
          OutputStream out = null;
  
          try
          {
              in = new FileInputStream(source);
              out = new FileOutputStream(destination);
  
              byte[] buffer = new byte[1024];
  
              int length;
              while ((length = in.read(buffer)) > 0)
              {
                  out.write(buffer, 0, length);
              }
          }
          catch (Exception e)
          {
              try
              {
                  in.close();
              }
              catch (IOException e1)
              {
                  e1.printStackTrace();
              }
  
              try
              {
                  out.close();
              }
              catch (IOException e1)
              {
                  e1.printStackTrace();
              }
          }
      }
  }
  */

  /*
  public static void swapEntities() {
    File file = new File(pathToTexturePack + "entity/");
    File[] files = file.listFiles();
    List<File> fileList = Arrays.asList(files);
    ArrayList<File> listOfEntities = new ArrayList<File>(fileList);

    Iterator<File> itr = listOfEntities.iterator();

    while(itr.hasNext()) {
      File entity = itr.next();
      if (!entity.isDirectory()) {
        itr.remove();
      }
    }

    int numEntities = listOfEntities.size();

    // ArrayLists to randomly map texture numbers
    ArrayList<Integer> textureList = new ArrayList<Integer>(numEntities);
    ArrayList<Integer> textureMap = new ArrayList<Integer>(numEntities);

    // Populate the textureList with 1 through n (number of textures)
    for(int i = 0; i < numEntities; i++) {
      textureList.add(i);
    }

    // Randomly map texture numbers to the textureList
    Random rand = new Random();
    while(textureList.size() > 0) {
      int index = rand.nextInt(textureList.size());
      textureMap.add(textureList.remove(index));
    }

    String oldTexturePath = "";
    String newTexturePath = "";

    for (int i = 0; i < textureMap.size(); i++) {

      // Get the string to the path of the old texture file
      oldTexturePath = pathToTextures + "entity/" + listOfEntities.get(i).getName();

      System.out.println("Old texture path: " + oldTexturePath);

      // Get the string to the path of the new texture file
      newTexturePath = pathToTexturePack + "entity/" + listOfEntities.get(textureMap.get(i)).getName();

      System.out.println("New texture path: " + newTexturePath);

      System.out.println("Old texture: " + oldTexturePath);
      System.out.println("New texture: " + newTexturePath);
      System.out.println("");

      // Get the reference entity directory
      File entityDir = new File(oldTexturePath);

      // Create the new texture file
      File newEntityDir = new File(newTexturePath);

      copyFolder(entityDir, newEntityDir);
    }

  }
  */

  public static void main(String[] args) {

    for (int textureType = 0; textureType < textureTypes.length; textureType++) {

      // Open the block texture directory
      File blockTextures = new File(pathToTextures + textureTypes[textureType]);

      // List of all texture filenames
      File[] listOfTextures = blockTextures.listFiles();

      // Get the number of block textures in the directory
      int numTextures = listOfTextures.length;

      // ArrayLists to randomly map texture numbers
      ArrayList<Integer> textureList = new ArrayList<Integer>(numTextures);
      ArrayList<Integer> textureMap = new ArrayList<Integer>(numTextures);

      // Populate the textureList with 1 through n (number of textures)
      for(int i = 0; i < numTextures; i++) {
        textureList.add(i);
      }

      // Randomly map texture numbers to the textureList
      Random rand = new Random();
      while(textureList.size() > 0) {
        int index = rand.nextInt(textureList.size());
        textureMap.add(textureList.remove(index));
      }

      String oldTexturePath = "";
      String newTexturePath = "";

      for (int i = 0; i < textureMap.size(); i++) {

        // Get the string to the path of the old texture file
        oldTexturePath = pathToTextures + textureTypes[textureType] + listOfTextures[i].getName();

        // Skip over any file that isnt a .png file
        if (!oldTexturePath.substring(oldTexturePath.length() - 4).equals(".png")) {
          continue;
        }

        // Get the string to the path of the new texture file
        newTexturePath = pathToTexturePack + textureTypes[textureType] + listOfTextures[textureMap.get(i)].getName();

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

    // This function might not be doable in any reasonable way.
    // The issue comes down to some animals having many texture files, while others
    // may only have one.
    //
    // For example, there is no decent way to remap a silverfish on to the ender dragons multiple textures.
    //
    // Since it isn't one to one, the problem is weird and doesn't really make sense to try to solve.
    //swapEntities();

  }

}