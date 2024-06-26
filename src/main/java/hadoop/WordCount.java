package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 如果需要本地运行，则需要导入这个包
 *
 * <dependency>
 * <groupId>org.apache.hadoop</groupId>
 * <artifactId>hadoop-mapreduce-client-common</artifactId>
 * <version>${v-hadoop}</version>
 * </dependency>
 *
 * @author lvsheng
 * @date 2019-09-01
 **/
public class WordCount {

    public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

        private final static IntWritable one  = new IntWritable(1);
        private              Text        word = new Text();

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                context.write(word, one);
            }
        }
    }


    public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        private IntWritable result = new IntWritable();

        @Override
        public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        long          start = System.currentTimeMillis();

        // 1. 获取配置文件对象，获取job对象实例
        Configuration conf  = new Configuration();
        Job           job   = Job.getInstance(conf, "word count");

        // 2. 指定程序jar的本地路径
        job.setJarByClass(WordCount.class);

        //  3. 指定Mapper/Reducer类
        job.setMapperClass(TokenizerMapper.class);
        job.setReducerClass(IntSumReducer.class);

        // 5. 指定最终输出的kv数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 6. 指定job处理的原始数据路径
        FileInputFormat.addInputPath(job, new Path("/Users/LvSheng/code/github/Test/data.txt"));
        //  7. 指定job输出结果路径
        FileOutputFormat.setOutputPath(job, new Path("/Users/LvSheng/code/github/Test/data_out"));

        //  8. 提交作业
        job.waitForCompletion(true);

        System.out.println("time cost ： " + (System.currentTimeMillis() - start) / 1000 + " s");
    }
}