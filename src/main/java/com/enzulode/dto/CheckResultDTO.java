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
	public final int x;
	public final float y;
	public final int r;
	public final String resultString;
	public final boolean result;
}
