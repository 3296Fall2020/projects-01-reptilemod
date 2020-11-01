# Minecraft Reptile Mod

-------------------------------------------
Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "unrenamed" MCP source code (aka
srgnames) - this means that you will not be able to read them directly against
normal code.

Source pack installation information:

Standalone source installation
==============================

See the Forge Documentation online for more detailed instructions:
http://mcforge.readthedocs.io/en/latest/gettingstarted/

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: "gradlew genEclipseRuns" (./gradlew genEclipseRuns if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run "gradlew eclipse" to generate the project.
(Current Issue)
4. Open Project > Run/Debug Settings > Edit runClient and runServer > Environment
5. Edit MOD_CLASSES to show [modid]%%[Path]; 2 times rather then the generated 4.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: "gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can run "gradlew --refresh-dependencies" to refresh the local cache. "gradlew clean" to reset everything {this does not affect your code} and then start the processs again.

Should it still not work, 
Refer to #ForgeGradle on EsperNet for more information about the gradle environment.
or the Forge Project Discord discord.gg/UvedJ9m

Forge source installation
=========================
MinecraftForge ships with this code and installs it as part of the forge
installation process, no further action is required on your part.

LexManos' Install Video
=======================
https://www.youtube.com/watch?v=8VEdtQLuLO0&feature=youtu.be

For more details update more often refer to the Forge Forums:
http://www.minecraftforge.net/forum/index.php/topic,14048.0.html

## Project Overview

## Vision Statement
For Minecraft players who want a more enriched experience with Minecraft’s creatures, or general fans of reptiles, Minecraft: Reptiles is a forge mod that allows players to interact with new mobs, bosses and items in unique ways, raising and battling new creatures or crafting items pertaining to reptiles.  Unlike existing nature and wildlife mods that look more broadly and only scratch the surface of what reptiles have to offer, Minecraft: Reptiles provides both immersion and challenge specific to reptiles, and will be compatible with the latest version of Minecraft, while other mods are still only released for older versions.
## Personas
- Kids
	* No technical skills
	* Interested in the game aspect
	* Limited computer knowledge
- Adult
	* Experienced with tech and software development
- Adult2
	* Experienced with games but no technical experience
- Mod Maker
	* High minecraft/coding experience
- Educator
	* Adam Smith is an elementary school education in Orlando, Florida.  He graduated from FSU in 2007 with an Education degree and has since taught 2nd–5th graders in a local elementary school.  
	* While Adam's not too technically adept, he's able to use Minecraft: Education Edition to complement the cirriculumn in a more interactive way, helping students to better grasp topics in STEM, history, coding, and more.
	* Recently, he's been looking for a way to teach his student's about local wildlife.  Minecraft's vanilla edition includes several common species, but not many common to his state of Florida.  Adam is interested in using the Reptiles mod to add some lizard species that are native to the area and are more relevant to the students.

## Feature List
