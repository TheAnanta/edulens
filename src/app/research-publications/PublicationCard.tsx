"use client"
import * as React from 'react';
import StarBorderIcon from '@mui/icons-material/StarBorder';
import StarIcon from '@mui/icons-material/Star';

const publications = [
  {
    title: "Understanding Quantum Computing",
    attribute: "Physics - Quantum Mechanics",
    description: "An in-depth exploration of quantum computing, its principles, and applications in modern technology.",
    rating: 4,
  },
  {
    title: "Advances in Artificial Intelligence",
    attribute: "Computer Science - AI",
    description: "A comprehensive review of the latest advancements in AI, including machine learning, neural networks, and deep learning.",
    rating: 5,
  },
  {
    title: "Climate Change and Its Global Impact",
    attribute: "Environmental Science",
    description: "An analysis of the ongoing effects of climate change on global ecosystems, economies, and human health.",
    rating: 3,
  },
  {
    title: "Exploring the Human Genome",
    attribute: "Biology - Genetics",
    description: "An overview of the human genome project and its implications for medicine and biotechnology.",
    rating: 4,
  },
  {
    title: "The Future of Renewable Energy",
    attribute: "Energy Science",
    description: "A discussion on the potential of renewable energy sources to meet future global energy demands.",
    rating: 5,
  },
  {
    title: "Cultural Shifts in the Digital Age",
    attribute: "Sociology - Culture",
    description: "Examining how digital technology is reshaping culture, communication, and society.",
    rating: 4,
  },
  {
    title: "Nanotechnology in Medicine",
    attribute: "Biotechnology - Nanomedicine",
    description: "A study on the applications of nanotechnology in the diagnosis and treatment of diseases.",
    rating: 4,
  },
  {
    title: "The Economics of Globalization",
    attribute: "Economics",
    description: "An analysis of the economic forces driving globalization and its effects on local and global markets.",
    rating: 3,
  },
  {
    title: "Cybersecurity Threats in the Modern World",
    attribute: "Computer Science - Cybersecurity",
    description: "A review of current cybersecurity threats and strategies to mitigate risks in a digital world.",
    rating: 5,
  },
  {
    title: "The Art of Minimalism",
    attribute: "Design - Art",
    description: "An exploration of minimalism in art and design, and its influence on contemporary aesthetics.",
    rating: 3,
  },
  {
    title: "Neuroscience: The Brain's Mysteries",
    attribute: "Neuroscience",
    description: "Insights into the latest research in neuroscience and the ongoing quest to understand the human brain.",
    rating: 4,
  },
  {
    title: "Artificial Intelligence Ethics",
    attribute: "Philosophy - Ethics",
    description: "A discussion on the ethical considerations and challenges posed by the development of artificial intelligence.",
    rating: 5,
  },
];

export default function PublicationCard(props: { title: string; attribute: string; description: string; rating: number }) {

  const ratingStars = [];
  for (let i = 0; i < 5; i++) {
    if (i < props.rating) {
      ratingStars.push(<StarIcon key={i} style={{ color: 'gold' }} />);
    } else {
      ratingStars.push(<StarBorderIcon key={i} style={{ color: 'grey' }} />);
    }
  }
  ratingStars.reverse();

  return (
    <div className="bg-[var(--secondary-color)] p-6 w-full rounded-3xl flex-col items-center justify-between space-y-8">
      <div className="flex justify-between items-center">
        <div>
          <p className="text-base uppercase font-bold">{props.title}</p>
          <p className="text-sm">{props.attribute}</p>
        </div>

        <div className="flex justify-end items-center space-x-2">
          <button className="text-[var(--main-color)] border rounded-3xl border-[var(--main-color)] px-8 py-2 text-sm font-medium">
            View
          </button>
          <button onClick={function(){
            alert("Saved!")
          }} className="bg-[var(--main-color)] border rounded-3xl text-white px-8 py-2 text-sm font-medium">
            Save
          </button>
        </div>
      </div>

      <p className="text-sm">
        {props.description}
      </p>

      <div className="flex flex-row-reverse">
        {ratingStars}
      </div>
    </div>
  );
}

// Example of rendering all the publication cards
export function PublicationList() {
  return (
    <div className="space-y-8">
      {publications.map((publication, index) => (
        <PublicationCard
          key={index}
          title={publication.title}
          attribute={publication.attribute}
          description={publication.description}
          rating={publication.rating}
        />
      ))}
    </div>
  );
}
