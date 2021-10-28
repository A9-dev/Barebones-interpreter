Bare Bones is the simple language that Brookshear uses in his book, ['Computer Science: an Overview'](https://www.amazon.co.uk/Computer-Science-Overview-Glenn-Brookshear/dp/0321544285/ref=sr_1_1?ie=UTF8&s=books&qid=1225741559&sr=8-1), to illustrate the power of Turing complete machines and investigate the halting problem.

Bare Bones has three simple commands for manipulating a variable:

    clear name;
    incr name;
    decr name;


...which respectively sets variable name to zero, increments it by one and decrements it by one.

The language also contains one control sequence, a simple loop:

    while name not 0 do;
    ...
    ...
    end;
... where name is a variable. Statements are delimited by the ; character.

Note that while loops must be terminated by an end statement, but that they can be nested.

⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣶⣄⣀⡀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  
⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣄⣀⡀⣠⣾⡇⠀⠀  ⠀⠀  
⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀  ⠀⠀⠀  
⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⡇⠀  ⠀⠀⠀  
⠀⣶⣿⣦⣜⣿⣿⣿⡟⠻⣿⣿⣿⣿⣿⣿⣿⡿⢿⡏⣴⣺⣦⣙⣿⣷⣄⠀  ⠀⠀  
⠀⣯⡇⣻⣿⣿⣿⣿⣷⣾⣿⣬⣥⣭⣽⣿⣿⣧⣼⡇⣯⣇⣹⣿⣿⣿⣿⣧⠀⠀    
⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠸⣿⣿⣿⣿⣿⣿⣿⣷⠀      
