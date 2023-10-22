package com.enzulode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CheckResultDTO
{
	private final int x;
	private final float y;
	private final int r;
	private final String result;
}
