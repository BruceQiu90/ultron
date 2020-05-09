package io.bruce.ultron;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkLauncher {

    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamEnv.initEnv();


    }
}
