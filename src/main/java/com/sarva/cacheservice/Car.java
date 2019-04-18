package com.sarva.cacheservice;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {

	private static final long serialVersionUID = -8765559709798892587L;

	private String id;

	private String make;

	private String model;

	private String year;

}
