import { AxiosResponse } from 'axios';
import { Landscape } from '../domain/landscape/Landscape';
import { RestLandscapeLevel, toLandscapeLevel } from './RestLandscapeLevel';

export interface RestLandscape {
  levels: RestLandscapeLevel[];
}

export const mapToLandscape = (response: AxiosResponse<RestLandscape>): Landscape => ({
  levels: response.data.levels.map(toLandscapeLevel),
});
