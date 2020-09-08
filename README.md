# sia-tp2

## Generate executable
`mvn clean install`

## Execute command

`java -jar target/sia-tp2-1.0.jar`

Note: you must have the configurations file to execute.

## Configurations file

`config.properties`

with all the following properties

```
weaponPath=
bootPath=
helmetPath=
glovesPath=
chestPath=
numberOfItems=
class=
randomSeed=
populationSize=
crossoverMethod=
mutationMethod=
mutationMethod.probability=
selectionMethod1=
selectionMethod1.percentage=
selectionMethod1.parameter=
selectionMethod2=
selectionMethod2.percentage=
selectionMethod2.parameter=
implementationMode=
implementationMode.parameter=
replacementMethod1=
replacementMethod1.percentage=
replacementMethod1.parameter=
replacementMethod2=
replacementMethod2.percentage=
replacementMethod2.parameter=
cutCondition=
cutCondition.parameter1=
cutCondition.parameter2=
```

## Parameters

| Parameter | Description and options |
| ------ | ----------- |
| weaponPath   | Path to weapons tsv. |
| bootPath | Path to boots tsv. |
| helmetPath    | Path to helmets tsv. |
| glovesPath    | Path to gloves tsv. |
| numberOfItems    | Number of items on tsv files. |
| class    | Options: ARCHER, ROGUE, DEFENDER, WARRIOR. |
| randomSeed    | Seed for randomizer(long type)(Optional, if not given will use random seed). |
| populationSize    | Size for genetics population. |
| crossoverMethod    | Options: UNIFORM, ANNULAR, DOUBLE_POINT, SINGLE_POINT. |
| mutationMethod    | Options: COMPLETE, ONE_GEN, LIMITED, UNIFORM. |
| mutationMethod.probability    | Probability for mutation method. |
| selectionMethod    | Options: ELITE, ROULETTE, RANKING, BOLTZMANN, UNIVERSAL, PROBABILISTIC_TOURNAMENT, DETERMINISTIC_TOURNAMENT. |
| selectionMethod.percentage    | percentage of method to be used(value from 0.0 to 1.0). |
| selectionMethod.parameter    | Parameter for the selection method. |
| replacementMethod    | same as selection method but for replacement part. |
| implementationMode    | Options: FILL_ALL, FILL_PARENT. |
| implementationMode.parameter    | Number of parents and children. |
| cutCondition    | Options: TIME, ACCEPTABLE, CONTENT, STRUCTURE. |
| cutCondition.parameter1    | Parameter 1 for the cut condition. |
| cutCondition.parameter2    | Parameter 2 for the cut condition. |

### Selection parameters
Only methods that use parameter

| Type | Description of parameters |
| ------ | ----------- |
| PROBABILISTIC_TOURNAMENT | Threshold of the method. Value from 0.5 to 1.0 |
| DETERMINISTIC_TOURNAMENT | M of the method. |

### Cut Condition parameters
Only methods that use parameter

| Type | Description of parameters |
| ------ | ----------- |
| TIME | parameter1: time to cut(long type). |
| GENERATION | parameter1: max generations to cut(int type). |
| CONTENT | parameter1: max generations with the same best character(int type). |
| ACCEPTABLE | parameter1: acceptable fitness(double type). |
| STRUCTURE | parameter1: number of population in common(int type). |
| STRUCTURE | parameter2: max generations with the number of population in common(int type). |

### Config examples

Example 1

```
weaponPath=fulldata/armas.tsv
bootPath=fulldata/armas.tsv
helmetPath=fulldata/cascos.tsv
glovesPath=fulldata/guantes.tsv
chestPath=fulldata/pecheras.tsv
numberOfItems=10000
class=ARCHER
randomSeed=7119717948961862689
populationSize=1000
crossoverMethod=DOUBLE_POINT
mutationMethod=UNIFORM
mutationMethod.probability=0.5
selectionMethod1=BOLTZMANN
selectionMethod1.percentage=0.8
selectionMethod1.parameter=
selectionMethod2=ELITE
selectionMethod2.percentage=0.2
selectionMethod2.parameter=
implementationMode=FILL_ALL
implementationMode.parameter=1500
replacementMethod1=DETERMINISTIC_TOURNAMENT
replacementMethod1.percentage=0.8
replacementMethod1.parameter=3
replacementMethod2=ELITE
replacementMethod2.percentage=0.2
replacementMethod2.parameter=
cutCondition=CONTENT
cutCondition.parameter1=1000
cutCondition.parameter2=
```

Example 2

```
weaponPath=fulldata/armas.tsv
bootPath=fulldata/armas.tsv
helmetPath=fulldata/cascos.tsv
glovesPath=fulldata/guantes.tsv
chestPath=fulldata/pecheras.tsv
numberOfItems=10000
class=WARRIOR
randomSeed=
populationSize=1500
crossoverMethod=DOUBLE_POINT
mutationMethod=UNIFORM
mutationMethod.probability=0.5
selectionMethod1=DETERMINISTIC_TOURNAMENT
selectionMethod1.percentage=0.5
selectionMethod1.parameter=3
selectionMethod2=ELITE
selectionMethod2.percentage=0.5
selectionMethod2.parameter=
implementationMode=FILL_ALL
implementationMode.parameter=1000
replacementMethod1=BOLTZMANN
replacementMethod1.percentage=0.8
replacementMethod1.parameter=3
replacementMethod2=ELITE
replacementMethod2.percentage=0.2
replacementMethod2.parameter=
cutCondition=CONTENT
cutCondition.parameter1=500
cutCondition.parameter2=
```

## Visual
To run the following python visual chart must install the following libraries:

`pip3 install pandas matplotlib`

To visualize the jar output must be piped to a .csv file using this command:

`java -jar target/sia-tp2-1.0.jar | output.csv`

Then with that file as argument run python file:

`python3 visual/time_vs_particles.py output.csv`

## Authors

Tomás Dallas

Tomás Dorado