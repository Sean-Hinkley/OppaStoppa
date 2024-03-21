// Inserts a sample document describing a movie by using the Java driver

package oppasition;

import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

public class App {
    public static void main(String[] args) {
        // Replace the uri string with your MongoDB deployment's connection string
        String uri = "mongodb+srv://seanhinkley567:<hi6yIe40>@cluster0.4qifbvj.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        ObjectId x;
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("RPG");
            MongoCollection<Document> collection = database.getCollection("Player");
            MongoCollection<Document> collection1 = database.getCollection("Player");

            try {
                // Inserts a sample document describing a movie into the collection
                InsertOneResult Inventory = collection1.insertOne(new Document() 
                        .append("_id", x=new ObjectId())
                        .append("Equips", Arrays.asList())
                        .append("Consumables", Arrays.asList())
                        .append("Quests", Arrays.asList())
                        .append("Quest_Items", Arrays.asList()));   
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("Level", 0)
                        .append("Inventory_Id", x));

                // Prints the ID of the inserted document
                System.out.println("Success! Inserted document id: " + result.getInsertedId());
            
            // Prints a message if any exceptions occur during the operation
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }
    }
}
