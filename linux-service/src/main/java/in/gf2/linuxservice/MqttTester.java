package in.gf2.linuxservice;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MqttTester implements Runnable {

	private final MqttConnectOptions mqttOptions;
	private MqttClient mqttClient;
	
	public MqttTester() {
		log.info("MQTT Tester Started!");
		mqttOptions = new MqttConnectOptions();
        mqttOptions.setMaxInflight(200);
        mqttOptions.setConnectionTimeout(60);
        mqttOptions.setKeepAliveInterval(30);
        mqttOptions.setCleanSession(false);
        run();
	}

	@Override
	public void run() {
		log.info("Test Running!!");
		for(int i = 0; i<2000; i++) {
            try {
                mqttClient = new MqttClient("tcp://192.168.68.118",
                    String.format("WPS_LPR_CONCENTRATOR_%d", i));
                mqttClient.connect(mqttOptions);
                mqttClient.subscribe("WPS"); 
                log.info(String.valueOf(i));
            } catch(Exception e) {
                log.error("Error", e);
            }
        }
	}
}
