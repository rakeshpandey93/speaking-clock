package com.speakingclock.speakingclock.clockTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.speakingclock.speakingclock.service.SpeakingClockService;

public class ClockServiceTest {

	private SpeakingClockService service;

	@Before
	public void setUp() {
		service = new SpeakingClockService();
	}

	@Test
	public void D_test() {
		String time = "08:34";

		String result = service.convert(time);

		assertEquals("It's eight thirty four", result);
	}

	@Test
	public void B_test() {
		String time = "12:00";

		String result = service.convert(time);

		assertEquals("It's Midday", result);
	}

	@Test
	public void C_test() {
		String time = "00:00";

		String result = service.convert(time);

		assertEquals("It's Midnight", result);
	}

	@Test
	public void L_testNull() {

		String result = service.convert(null);

		assertEquals("Given time is not valid!", result);
	}
}