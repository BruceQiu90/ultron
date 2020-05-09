package io.bruce.ultron;

import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamEnv {

    public static StreamExecutionEnvironment initEnv() {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.getConfig().disableSysoutLogging();
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
        env.setRestartStrategy(RestartStrategies.fixedDelayRestart(Integer.MAX_VALUE, Time.seconds(30)));
        env.enableCheckpointing(Time.minutes(10).toMilliseconds(), CheckpointingMode.EXACTLY_ONCE);
        // 指定checkpoint执行的超时时间
        env.getCheckpointConfig().setCheckpointTimeout(Time.minutes(9).toMilliseconds());
        // checkpoint完成之后最小等多久可以出发另一个checkpoint
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(Time.seconds(30).toMilliseconds());
        // cancel后保留checkpoint
        env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);
        return env;
    }
}
