package com.arc.core.constant;

import java.util.Locale;

@Deprecated// see FileUtil arc-util 包提供
public interface MusicSuffix {

    String mp3 = "mp3";
    String MP3 = mp3.toLowerCase(Locale.ROOT);
    String wav = "wav";
    String WAV = "WAV";
}
