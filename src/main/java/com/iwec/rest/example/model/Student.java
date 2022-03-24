package com.iwec.rest.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Integer id;

	@NonNull
	private String Name;

	@NonNull
	private String Name;

}
