
public class Pipe {
    
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-pipe");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); 
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());   
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        final StreamsBuilder builder = new StreamsBuilder();
        final KStream<String, String> source = builder.stream("streams-plaintext-input");
        
        /*
        //Map values to upper case
        source.mapValues(value -> value.toUpperCase())
              .to("streams-pipe-output");
              */
        //send data to streams-pipe-output
        source.to("streams-pipe-output");

        //concatenate the input stream with the output stream
        builder.stream("streams-plaintext-input").to("streams-pipe-output")

        final Topology topology = builder.build();
        System.out.println(topology.describe());
        

    }
        
}
