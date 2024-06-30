/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.rasc.bsoncodec.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;

/**
 * Marks a class for the annotation processor to create a {@link Codec} implementation.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface BsonDocument {

	/**
	 * Fully qualified classname of the {@link CodecProvider} that the generated
	 * {@link Codec} implementation should be added.
	 * <p>
	 * By default a class with name <code>PojoCodecProvider</code> is created in every
	 * package the processor finds classes with the {@link BsonDocument} annotation. The
	 * PojoCodecProvider contains a registry for every Codec from this package.
	 */
	String codecProviderClassName() default "";

	/**
	 * Controls if fields with null value should be stored in the database.
	 * <p>
	 * Default behavior is not storing null values (false)
	 */
	boolean storeNullValues() default false;

	/**
	 * Controls if empty collections and arrays should be stored in the database.
	 * <p>
	 * Default behavior is not storing empty collections and arrays (false)
	 */
	boolean storeEmptyCollections() default false;

	/**
	 * Controls the behavior of the decoder when he encounters fields that cannot be
	 * mapped to the pojo. true ignores these fields silently. false throw an exception.
	 * <p>
	 * Default is ignore unknown fields (true)
	 */
	boolean ignoreUnknown() default true;
}
