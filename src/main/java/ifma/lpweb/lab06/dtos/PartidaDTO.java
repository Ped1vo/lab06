package ifma.lpweb.lab06.dtos;

import lombok.Data;

@Data
public class PartidaDTO {
    private Long id;
    private String data;
    private String local;
    private String timeCasa;
    private String timeVisitante;
    private int golsCasa;
    private int golsVisitante;

}
