# RecommendationEngine
Recommendation engine for any e-commerce depending on common attributes between the products. Attributes are assigned weights and higher the weight of the attribute in common,
more similar is the product with the input product

Build command : mvn install
This will create har in target folder

Run command : java -jar recommendationEngine-1.0-SNAPSHOT.jar $skucode

Default input file path can be mentioned in : inputFile.properties
Format of inpt file is : {skuid1: {attr1:attr1_value,attr2:attr2_value}, skuid2: {attr1:attr1_value2,attr2:attr2_value2}


Input json file is configured in the code, if a different file is to be given, add the path as an argument  like shown below
java -jar recommendationEngine-1.0-SNAPSHOT.jar sku-4499 /home/tejashree/input.json

Code structure:
There are factories for recommendation engines, the implementation can be changed as per need. Current implementation checks for similar attributes nad gives top 10 skus
Factores are written for input too, current input is from a file. It can be from DB too.
Attributes have comparator to determine the order

Improvements suggested:
1. Each time the program runs, input file os processed. This can be minimised if the data from input file is stored somewhere (redis cache or memcache)
2. Input processor has recommendation engine. These two can be decoupled so as to be used differently
3. Input file can be configured as an argument
