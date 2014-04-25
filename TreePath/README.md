README Tree Path

/bin : has Main.class - start point for the application
/bin/tree : Node.class - Node implemetation
            path.class - This is path generator , creates list of combination paths from the user input path
            Tree.class - This has the Tree algorithms implemented to insert,collapse,find synonym tree
       <br />
          
/src : Source Code for .java extension for the above files 

How to Run:

Compile the code and then 

java Main<br />
Enter the Path<br />                     //perform insertion any ways burst mode or one by one
1: Give Path to insert<br />            //if node already present doesn't create duplicate  
2: Collapse<br />                       //if give path is not present it create from where the mismatch is
3: Subtree Detection<br />
4: Exit<br />
Enter Option by the number given<br />
1
Enter Path
/sopley
scopley

Enter the Path            
1: Give Path to insert
2: Collapse
3: Subtree Detection
4: Exit
Enter Option by the number given
1
Enter path

/scopley/ab|cd/ef|gh                        //insertion using "|" expression

scopley	
cd	ab	ab-cd	
gh	ef	ef-gh	gh	ef	ef-gh	gh	ef	ef-gh	

1: Give Path to insert
2: Collapse                //Perform collapse operation
3: Subtree Detection
4: Exit
Enter Option by the number given
2
/scopley/ab|cd/ef|gh


Enter the Path
1: Give Path to insert
2: Collapse
3: Subtree Detection
4: Exit
Enter Option by the number given
1
Enter path
/scopley/ab-cd/zz

scopley     
cd	ab	ab-cd       
gh	ef	ef-gh	gh	ef	ef-gh	gh	ef	ef-gh	zz              //zz added under /scopley/ab-cd


Enter the Path
1: Give Path to insert
2: Collapse
3: Subtree Detection                                     //subtree, print synonyms
4: Exit
Enter Option by the number given
3
Enter path
/scopley/ab
[/scopley/cd, /scopley/ab]          ///because these two have same child nodes ie ef|gh , /scopley/ab-cd missed out                                          ///because it has zz under which makes it different



