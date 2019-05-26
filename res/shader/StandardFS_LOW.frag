#version 330 core

in vec2 textureCoords;
in vec3 fragmentPosition;

out vec4 out_Color;

uniform sampler2D textureSampler;
uniform vec4 colorVector;

uniform vec3 lightColors[10];
uniform vec3 lightAttenuations[10];
uniform float lightBrightness[10];
uniform vec2 lightPositions[10];
uniform float lightRadius[10];

void main(void)
{
	vec4 fragColor = texture(textureSampler, textureCoords);;
	vec4 addedColor = colorVector + fragColor;
	vec4 colorWithLight = addedColor;
	
	for(int i = 0; i < 10; i++){
		if(lightBrightness[i] > 0.01){	
			float distance = distance(fragmentPosition.xy, lightPositions[i]);
			distance = distance / lightRadius[i];
			float attenuationFactor = 1 / (lightAttenuations[i].x + (lightAttenuations[i].y * distance) + (lightAttenuations[i].z * distance * distance));
			vec3 lightColor = lightColors[i] * lightBrightness[i] * attenuationFactor;
			colorWithLight = colorWithLight + vec4(lightColor, 0.0);
		}
	}    
	
	out_Color = vec4(colorWithLight.rgb, addedColor.a);

}

