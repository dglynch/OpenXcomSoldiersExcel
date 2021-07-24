# OpenXcom Soldiers Excel

This program reads from the specified OpenXcom save file and writes information about the soldiers to the specified
Excel file. The information is the same as what can be obtained inside the game. Additionally, the program calculates
the "promotion score" of each soldier, so you can easily see who will be promoted next when there is an opening at a
higher rank. The formula for the promotion score comes from https://www.ufopaedia.org/index.php/Rank#Higher_promotions.

The program takes two required parameters: the input file name (an OpenXcom save file), and the output file name (an
Excel file).

Right now, the project is only available as source code. It can be built and run just like any other Java console
application, using the Gradle build system. Specifically, the following command should work if you already have the JDK
installed:

    ./gradlew build run --args "/path/to/inputfile.sav /path/to/outputfile.xlsx"

In the future, I may package the project for release in a more convenient executable form for ordinary users.

## License

OpenXcom Soldiers Excel is free software: you can redistribute it and/or modify it under the terms of the GNU General
Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
later version. See [COPYING](COPYING) for details.
