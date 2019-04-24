package VoiceDetection;

import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.decoder.adaptation.Stats;
import edu.cmu.sphinx.decoder.adaptation.Transform;
import edu.cmu.sphinx.result.WordResult;

/**
 * A simple voice detector
 * 
 */
public class SimpleDetector {

    public static void main(String[] args) throws Exception {
        System.out.println("Loading models...");

        Configuration configuration = new Configuration();

        // Load models from the jar
        configuration
                .setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration
                .setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration
                .setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        // Create speech detection/input classes
       // StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(
               // configuration);
        //InputStream stream = SimpleDetector.class
                //.getResourceAsStream("/VoiceSamples/VoiceTest.wav");
                
         // Create Live Microphone feed
         
         
        System.out.format("Microphone Activated. Start speaking please \n");
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        recognizer.startRecognition(true);
                  
        SpeechResult result  = recognizer.getResult();
        
      
        
       // SpeechResult result;
        //stream.skip(44);

        // Stats class is used to collect speaker-specific data
        // Stats stats = recognizer.createStats(1);

        while (result != null || result.getHypothesis() == "stop") {
         
            //stats.collect(result);
            
            //Transform represents the speech profile
           // Transform transform = stats.createTransform();
           //recognizer.setTransform(transform);
            
            if(result.getHypothesis().isEmpty() == false){
                if(result.getHypothesis().length() > 4){
                System.out.format("Voice Detected: \n");
                System.out.format("Approximate Transcription: %s\n", result.getHypothesis());
                }
            }
          
            result  = recognizer.getResult();
        }
        
        recognizer.stopRecognition();

        // Transform represents the speech profile
       // Transform transform = stats.createTransform();
        //recognizer.setTransform(transform);

        // Decode again with updated transform
        //stream = SimpleDetector.class
               // .getResourceAsStream("/VoiceSamples/VoiceTest.wav");
        //stream.skip(44);
       //recognizer.startRecognition(false);
       
       /*
        while ((result = recognizer.getResult()) != null) {
            if(result.getHypothesis().isEmpty() == false){
                System.out.format("Voice Detected: \n");
                System.out.format("Approximate Transcription: %s\n", result.getHypothesis());
            }
           
        }
        recognizer.stopRecognition();
        */
    }

}