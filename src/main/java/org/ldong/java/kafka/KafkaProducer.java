package org.ldong.java.kafka;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Title: KafkaProducer.java
 * @Copyright: Copyright (c) 2015
 * @Description: <br>
 *               kafka客户端，目的是向kafka中灌数据 <br>
 * @Created on 2016年3月10日 下午4:44:40
 */
public class KafkaProducer {

	public static void main(String[] args) {
		writeKafka("D:\\testData\\output\\interactive_all.txt");
//		 writeKafka();
	}

	/**
	 * 读取文件内容 将文件内容写入kafka
	 */
	private static void writeKafka(String filePath) {
		/**
		 * 读取文件内容
		 */
		String file = filePath;
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(new File(file), Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (null == lines || lines.size() < 1) {
			try {
				throw new Exception("文件：" + file + "nothing");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 将文件内容写入Kafka
		 */
		LogProducer producer = null;
		try {
			producer = new LogProducer();

			producer.send("interactive2", lines);

			System.out.println("Send finished");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (producer != null) {
				producer.close();
			}
		}

	}

	private static void writeKafka() {

		List<String> lines = new ArrayList<String>(20);

		for (int i = 0; i < 20; i++) {
			String line = i + "," + UUID.randomUUID();
			lines.add(line);
		}

		/**
		 * 将文件内容写入Kafka
		 */
		LogProducer producer = null;
		try {
			producer = new LogProducer();

			producer.send("test3", lines);

			System.out.println("Send finished");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (producer != null) {
				producer.close();
			}
		}

	}

}
