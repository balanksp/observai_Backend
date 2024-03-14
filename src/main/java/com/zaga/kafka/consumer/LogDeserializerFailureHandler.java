package com.zaga.kafka.consumer;

import io.smallrye.common.annotation.Identifier;
import io.smallrye.reactive.messaging.kafka.DeserializationFailureHandler;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.common.header.Headers;

import com.zaga.entity.otellog.OtelLog;

/**
 * A deserialization failure handler for log messages from Kafka.
 */

@ApplicationScoped
@Identifier("log-failure-fallback")
public class LogDeserializerFailureHandler
  implements DeserializationFailureHandler<OtelLog> {

  /**
   * Handles deserialization failures for log messages.
   *
   * @param topic        The topic from which the message was consumed.
   * @param isKey        Whether the message is a key.
   * @param deserializer The deserializer being used.
   * @param data         The raw message data.
   * @param exception    The exception that occurred during deserialization.
   * @param headers      The headers associated with the message.
   * @return Returns null to skip the problematic message
   * and continue processing the next message.
   */

  @Override
  public OtelLog handleDeserializationFailure(
    final String topic,
    final boolean isKey,
    final String deserializer,
    final byte[] data,
    final Exception exception,
    final Headers headers
  ) {
    // Log the deserialization failure with the relevant information
    System.err.println("Deserialization failed for message in topic: " + topic);
    System.err.println("Exception: " + exception.getMessage());

    // Return null to skip the problematic message
    // and continue processing the next message.
    return null;
  }
}

    

