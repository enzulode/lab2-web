package com.enzulode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class ErrorDTO
{
	private final String message;
}
