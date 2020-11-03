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
Minecraft: Reptiles adds new passive, neutral and hostile mobs to various Minecraft biomes.  New items provide tools specific to reptiles, and offer a choice between efficacy and unique effects.  The various reptiles can be captured, and kept in customizable tanks to keep as pets.  A new boss unique to the ocean and swamp biomes seems to be lurking, but is often regarded as just a myth.  Explore a more diversely populated world with Minecraft: Reptiles.

## Updated Project Proposal
We propose a contribution to the popular game Minecraft in the form of a mod.  Minecraft is a sandbox game in which players can build endless creations with countless blocks. The game has been extremely popular with people of all ages since around 2010. There are different modes to play, the main two being creative mode, where players have an endless supply of blocks to use to build whatever they want, and survival mode, where players can explore worlds in different ways, all while having to survive.

Minecraft has a number of animals in its world that the player can interact with.  Although the variety of animals has increased with continued development, we want to contribute to the ecological diversity in the game through our mod.  Our focus will be on introducing different types of reptiles.  We are all fans of this game and can use our passion and experience to provide exciting features for new and old players alike.

The goal of this project is to build on the Minecraft experience by adding a number of reptile mobs to the game.  Each reptile will be distinct and have realistic behaviors inspired by nature.  For example, we will incorporate a chameleon that attempts to camouflage to its surroundings and a crocodile that preys on other unsuspecting mobs.  We will also create custom items and tools that will tie our new fauna into the Minecraft world, creating new challenges for players.

Our project is well aligned with the educational goals of this class.  The development for Minecraft: Reptiles will require extensive use of Object Oriented Design and Design Patterns as we build on legacy code and add new features.  Project management and version control will also be critical to the success of our project.


## Vision Statement
For Minecraft players who want a more enriched experience with Minecraft’s creatures, or general fans of reptiles, Minecraft: Reptiles is a forge mod that allows players to interact with new mobs, bosses and items in unique ways, raising and battling new creatures or crafting items pertaining to reptiles.  Unlike existing nature and wildlife mods that look more broadly and only scratch the surface of what reptiles have to offer, Minecraft: Reptiles provides both immersion and challenge specific to reptiles, and will be compatible with the latest version of Minecraft, while other mods are still only released for older versions.

## Feature List
[Link To Trello Project Board](https://trello.com/b/eVUMAlvM/minecraft-reptile-mod)

## Personas
### Timmy, a middle schooler
Timmy, age 12, is a middle school student.  Timmy lives with his family and his favorite subject in school is science.  He has a pet bearded dragon and owns a number of books on reptiles.  After school and homework he likes to spend his time playing video games.  He prefers sandbox and low stress video games because Timmy finds them relaxing and enjoys setting his own goals.

Timmy has played Minecraft for a few years and is comfortable with the game.  Recently he has been looking for new challenges in the game and started reading about mods on the internet.  He is interested in the Minecraft Reptile mod because he saw that there is a bearded dragon mob included.  He wants to use the mod to interact with some of the reptiles that he has read about and expects them to behave both realistically and aligned with his expectations from other Minecraft mobs.

- Adult
	* Experienced with tech and software development
	
### Adult with gaming experience, but no tech experience
Tom is a restaurant owner in San Diego, California who spent a lot of his teenage years playing all different types of video games, including Minecraft. Over time, as he grew older he lost his passion for playing video games and started his new hobby of cooking, eventually opening his own restaurant. Since moving into his own apartment, he discovered that he really likes reptiles, and has a few of his own. 

One of his younger employees mentioned that they found the Minecraft Reptile mod online, and they said that it sparked their interest in the game again. The next night he went home and re-downloaded Minecraft and installed the Minecraft Reptile mod very easily just by dragging and dropping a folder into the right location, which is very easy to figure out, even for someone with minimal tech experience. After playing for a little while, he encountered some of the reptiles that he owns and sparked his interest in the game again. 

	
### John, a modder
John, a 21 year old college student, studies at RPI in New York.  He spent years growing up playing Minecraft, and after a few, found the game to become somewhat stale and repetitive, but still wanted to play.  He eventually discovered mods, and through them, mod packs.  He started to play the game in all kinds of new ways, with expansions to nature, tech, space, challenges, and much more.  

Eventually he built up a list of favored mods, and modpacks, but was curious if he could start to build his own mods and packs.  He built some baseline mods, and has a lot of experience with computers, technology in general, and software design principles. He decided to put his own pack together for the latest version of Minecraft, and was looking to find something that adds to the game one of his other defining hobbies from his childhood - raising his pet bearded dragon.  In his search, he found Minecraft: Reptiles.  He finds this mod appealing because not only does it add a creature he is already interested in, but it integrates really well with other mods without adding redundant features, and he can tweak different things about the mod to meet his needs within his pack.

### Adam, a Teacher
Adam Smith is an elementary school teacher in Orlando, Florida.  He graduated from FSU in 2007 with an education degree and has since taught 2nd–5th graders in a local elementary school.  He's an avid outdoorsman with a love for nature.  While Adam's not too technically adept, he's able to use Minecraft: Education Edition to complement the curriculum in a more interactive way, helping students to better grasp topics in STEM, history, coding, and more.

Recently, he's been looking for a way to teach his students about local wildlife.  Minecraft's vanilla edition includes several common species, but not many common to his state of Florida.  Adam is interested in using the Reptiles mod to add some lizard species that are native to the area and are more relevant to the students.
