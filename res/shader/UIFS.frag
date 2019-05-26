#version 330 core

in vec2 textureCoords;

out vec4 out_Color;

uniform sampler2D guiTexture;
uniform vec4 colorVector;

void main(void)
{
	vec4 newColor = colorVector + texture(guiTexture, textureCoords);
	out_Color = newColor;
}