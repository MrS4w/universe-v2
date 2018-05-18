package br.model;

import java.util.ArrayList;
import java.util.List;

public class App {

	private static volatile App instance;

	private static int id = 0;
	private List<StarMom> star = new ArrayList<>();

	private static int idB = 0;
	private List<StarMom> blackhole = new ArrayList<>();

	private int idH = 0;
	private List<GalaxyMom> galaxy = new ArrayList<>();

	private int idF = 0;
	private List<GalaxyMom> system = new ArrayList<>();

	private App() {
		for (int i = 0; i < 10; i++) {
			Star starmom = new Star();
			id++;
			starmom.setId(id);
			starmom.setName("Star " + i);
			starmom.setVolume(0);
			starmom.setPosition(null);
			starmom.setVisible(false);
			star.add(starmom);
		}

		for (int i = 0; i < 10; i++) {
			BlackHole starmom = new BlackHole();
			id++;
			starmom.setId(id);
			starmom.setName("Star " + i);
			starmom.setVolume(0);
			starmom.setPosition(null);
			starmom.setVelocity(0);
			blackhole.add(starmom);
		}

		for (int i = 0; i < 10; i++) {
			Galaxy galaxymom = new Galaxy();
			idH++;
			galaxymom.setId(idH);
			galaxymom.setName("Herói " + i);
			galaxymom.setPosition(null);
			galaxymom.setDimension(0);
			galaxymom.setQuantity(0);

			galaxy.add(galaxymom);
		}

		for (int i = 0; i < 10; i++) {
			System galaxymom = new System();
			idF++;
			galaxymom.setId(idF);
			galaxymom.setName("Herói " + i);
			galaxymom.setPosition(null);
			galaxymom.setDimension(0);
			galaxymom.setConstelation(null);

			system.add(galaxymom);
		}
	}

	public static App getInstance() {
		if (instance == null) {
			synchronized (App.class) {
				if (instance == null)
					instance = new App();
			}
		}
		return instance;
	}

	public void addStar(StarMom starmom) {
		id++;
		starmom.setId(id);
		star.add(starmom);
	}

	public void addBlackHole(StarMom starmom) {
		idB++;
		starmom.setId(idB);
		blackhole.add(starmom);
	}

	public void addGalaxy(GalaxyMom galaxymom) {
		idH++;
		galaxymom.setId(idH);
		galaxy.add(galaxymom);
	}

	public void addSystem(GalaxyMom galaxymom) {
		idF++;
		galaxymom.setId(idF);
		system.add(galaxymom);
	}

	public void removeStar(StarMom starmom) {
		star.remove(starmom);
	}

	public void removeBlackHole(StarMom starmom) {
		blackhole.remove(starmom);
	}

	public List<StarMom> getStars(String name) {
		if (name == null || name.isEmpty())
			return star;

		List<StarMom> result = new ArrayList<>();
		for (StarMom x : star) {
			if (x.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(x);
			}
		}
		return result;
	}

	public StarMom getStar(int id) {
		StarMom starmom = null;
		for (StarMom x : star) {
			if (x.getId() == id) {
				starmom = x;
				break;
			}
		}
		return starmom;
	}

	public List<StarMom> getBlackHoles(String name) {

		if (name == null || name.isEmpty())
			return blackhole;

		List<StarMom> result = new ArrayList<>();
		for (StarMom a : blackhole) {
			if (a.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(a);
			}
		}
		return result;
	}

	public StarMom getBlackHole(int id) {
		StarMom starmom = null;
		for (StarMom a : blackhole) {
			if (a.getId() == id) {
				starmom = a;
				break;
			}
		}
		return starmom;
	}

	public List<GalaxyMom> getGalaxies(String name) {
		if (name == null || name.isEmpty())
			return galaxy;

		List<GalaxyMom> result = new ArrayList<>();
		for (GalaxyMom x : galaxy) {
			if (x.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(x);
			}
		}
		return result;
	}

	public GalaxyMom getGalaxy(int id) {
		GalaxyMom Galaxy = null;
		for (GalaxyMom x : galaxy) {
			if (x.getId() == id) {
				Galaxy = x;
				break;
			}
		}
		return Galaxy;
	}

	public List<GalaxyMom> getSystems(String name) {
		if (name == null || name.isEmpty())
			return system;

		List<GalaxyMom> result = new ArrayList<>();
		for (GalaxyMom x : system) {
			if (x.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(x);
			}
		}
		return result;
	}

	public GalaxyMom getSystem(int id) {
		GalaxyMom System = null;
		for (GalaxyMom x : system) {
			if (x.getId() == id) {
				System = x;
				break;
			}
		}
		return System;
	}

	public void removerGalaxy(GalaxyMom galaxymom) {
		galaxy.remove(galaxymom);
	}

	public void removerSystem(GalaxyMom galaxymom) {
		system.remove(galaxymom);
	}
}
