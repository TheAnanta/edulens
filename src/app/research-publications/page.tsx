import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import PublicationCard from "./PublicationCard";
import Footer from "@/components/Footer";

const ResearchData = [
  {
    attribute: "Dr. Emily Carter",
    title: "Quantum Computing for AI",
    description:
      "An exploration of how quantum computing can revolutionize artificial intelligence, with a focus on complex problem-solving.",
    rating: 5,
  },
  {
    attribute: "Prof. John Doe",
    title: "Advancements in Renewable Energy",
    description:
      "A comprehensive review of the latest technologies in renewable energy, including solar, wind, and bioenergy.",
    rating: 4,
  },
  {
    attribute: "Dr. Alice Smith",
    title: "Genomics and Personalized Medicine",
    description:
      "How genomic research is leading to personalized treatments in medicine, offering targeted therapies for various diseases.",
    rating: 5,
  },
  {
    attribute: "Prof. Mark Wilson",
    title: "Cybersecurity Threats in the IoT Era",
    description:
      "Analyzing the increasing cybersecurity risks associated with the proliferation of Internet of Things (IoT) devices.",
    rating: 3,
  },
  {
    attribute: "Dr. Olivia Johnson",
    title: "AI Ethics and Society",
    description:
      "An in-depth discussion on the ethical considerations of artificial intelligence in modern society.",
    rating: 4,
  },
  {
    attribute: "Prof. Michael Brown",
    title: "Climate Change: A Global Perspective",
    description:
      "Examining the long-term effects of climate change on global ecosystems and human populations.",
    rating: 4,
  },
  {
    attribute: "Dr. Sophia Davis",
    title: "Nanotechnology in Cancer Treatment",
    description:
      "Exploring the potential of nanotechnology in developing innovative treatments for cancer.",
    rating: 5,
  },
];

export default function Page() {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-36 px-24 w-full">
        <div className="flex space-x-4">
          <div className="text-2xl font-semibold uppercase">
            Research Publications
          </div>
        </div>
        <div className="grid grid-cols-2 mt-10 mb-16 gap-8 w-full">
          {ResearchData.map((item, index) => (
            <PublicationCard
              attribute={item.attribute}
              title={item.title}
              description={item.description}
              key={index}
              rating={item.rating}
            />
          ))}
        </div>
      </div>
    </div>
  );
}
