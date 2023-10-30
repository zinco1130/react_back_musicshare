package com.zinco.react_back.service;

import com.zinco.react_back.entity.Music;
import com.zinco.react_back.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {

    private final ManiaDbService maniaDbService;

    private final MusicRepository musicRepository;

    @Autowired
    public MusicService(ManiaDbService maniaDbService, MusicRepository musicRepository) {
        this.maniaDbService = maniaDbService;
        this.musicRepository = musicRepository;
    }

    public Music createMusicFromApi(String title) {
        ManiaDbApiResponse response = maniaDbService.getMusicInfo(title);

        Music music = new Music();
        music.setTitle(response.getTitle());
        music.setSinger(response.getSinger());

        musicRepository.save(music);

        return music;
    }
}
