/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoboRace;

import COSC3P40.midi.MidiManager;
import COSC3P40.sound.Sound;
import COSC3P40.sound.SoundManager;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author ym14tm
 */
public class PlaySound extends SoundManager 
{
    private static SoundManager soundManager = new SoundManager(new AudioFormat(8000,8,1,false,false));
    MidiManager midiManager=new MidiManager();
    File BGM=new File("Sounds&Midi/animaniacs.mid");
    static File bump = new File("Sounds&Midi/bump.wav");
    static File victory = new File("Sounds&Midi/fanfare.wav");
    static File destory = new File("Sounds&Midi/explosion.wav");
    Sequence sequence;
    AudioInputStream stream;
    static Sound bumpSound,victorySound,destorySound;
    
    public PlaySound(AudioFormat playbackFormat) throws InvalidMidiDataException 
    {
        super(playbackFormat); 
        try 
        {
            sequence = MidiSystem.getSequence(BGM);
            this.stream = AudioSystem.getAudioInputStream(bump);
            bumpSound = soundManager.getSound(stream);
            stream = AudioSystem.getAudioInputStream(victory);
            victorySound = soundManager.getSound(stream);
            stream = AudioSystem.getAudioInputStream(destory);
            destorySound = soundManager.getSound(stream);
            stream.close();
        } 
        catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PlaySound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlaySound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void playBump()
    {
        soundManager.play(bumpSound);     
    }
    public static void playVictory()
    {
        soundManager.play(victorySound);
    }
    public static void playDestory()
    {
        soundManager.play(destorySound);
    }
    public void playBGM() {
        midiManager.play(sequence,true);
    }
}
