# DFA-creator
**Example of dfa.txt (SAVED IN DESKTOP!!)**

    3
    0 1
    0
    0 1
    0 1 1
    0 0 0
    1 1 2
    1 0 0
    2 1 2
    2 0 2
    

## Explanation

    3 => DFA has 3 states
    
    0 1 => DFA has 2 symbols, 0 and 1
    
    0 => Starting state is q0
    
    0 1 => Final states are q0 and q1
    
    0 1 1 => In q0 state: if 1 go to state q1
    
    0 0 0 => In q0 state: if 0  go to state q0
    
    1 1 2 => In q1 state: if 1 go to state q2
    
    1 0 0 => In q1 state: if 0 go to state q0
    
    2 1 2 => In q2 state: με 1 go to state q2
    
    2 0 2 => In q2 state: με 0 go to state q2
  
So, basically the dfa.txt file we have as an example describes this dfa model:
![](https://eclass.uniwa.gr/courses/ICE319/image/dfa.png)

## Executing the program
We export it as a jar with entry point: **MainClass**
		and then we run it with the following command:

    java -jar name_of_file.jar
